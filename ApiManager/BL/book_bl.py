import DL.base_dl as base_dl
from bson.objectid import ObjectId
from datetime import date


def get_list_books(name_book):
    books = base_dl.get_data('books', {'name': {'$regex': name_book, '$options': 'i'}}, {})
    return books

def add_book(book):
    book_id = base_dl.insert_one_data('books', book)
    book = base_dl.get_data_one('books', {'borrower': book_id})
    return book

def add_user_borrow(data):
    user_id = data["user_id"]
    book_id = data["book_id"]
    borrow_date = date.now()
    base_dl.update_data('books', {"_id": ObjectId(book_id)},{"borrower": user_id, "borrow_date": borrow_date})
    book = base_dl.get_data_one('books', {"_id": ObjectId(book_id)})
    return book

def give_book_back(data):
    book_id = data["book_id"]
    give_back_date = date.now()
    base_dl.update_data('books', {"_id": ObjectId(book_id)},{"borrower": None, "give_back_date": give_back_date})
    book = base_dl.get_data_one('books', {"_id": ObjectId(book_id)})
    return book

def get_list_borrow_book():
    books = base_dl.get_data('books', {"borrower":None})
    return books