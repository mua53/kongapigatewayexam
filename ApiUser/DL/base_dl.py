#Data Layer
import os
import pymongo

client = pymongo.MongoClient(os.getenv('URL_MONGODB'))
db = client['borrow_book']

#Get data from db
def get_data(collection, query, sort):
    result = db[collection].find(query)
    for data in result:
        data['_id'] = str(data['_id'])
    return list(data)

def get_data_one(collection, query):
    data = db[collection].find_one(query)
    if data:
        data['_id'] = str(data['_id'])
    return data

def insert_data(collection, data):
    ids = db[collection].insert_many(data)
    return ids

def insert_one_data(collection, data):
    data = db[collection].insert_one(data)
    return data

def update_data(collection, query, data):
    db[collection].update_one(query,data)

def update_many_data(collection, query, data):
    db[collection].update_many(query,data)

def delete_data(collection, query):
    db[collection].delete_one(query)

def delete_many_data(collection, query):
    db[collection].delete_many(query)