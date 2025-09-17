const { v4: uuidv4 } = require('uuid');
const { getDb } = require('../db/mongo');

async function createBrand(call, callback) {
    try {
        const brand = call.request.brand || {};
        const id = brand.id || uuidv4();
        const doc = {
            id,
            name: brand.name || '',
            description: brand.description || '',
            tags: brand.tags || [],
            createdAt: new Date()
        };

        const db = getDb();
        await db.collection('brands').insertOne(doc);

        callback(null, { id, success: true, message: 'Brand created' });
    } catch (err) {
        console.error('createBrand error:', err);
        callback(null, { id: '', success: false, message: err.message || 'failed' });
    }
}

module.exports = { createBrand };
