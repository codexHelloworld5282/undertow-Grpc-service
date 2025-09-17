const { MongoClient } = require('mongodb');

const MONGO_URL = process.env.MONGO_URL || 'mongodb://localhost:27017';
const DB_NAME = process.env.DB_NAME || 'brandsdb';

let client;
let db;

async function connect() {
    if (db) return db;
    client = new MongoClient(MONGO_URL);
    await client.connect();
    db = client.db(DB_NAME);
    // ensure index on id or name if you want
    await db.collection('brands').createIndex({ id: 1 }, { unique: true });
    return db;
}

function getDb() {
    if (!db) throw new Error('MongoDB not connected. Call connect() first.');
    return db;
}

async function close() {
    if (client) await client.close();
}

module.exports = { connect, getDb, close };
