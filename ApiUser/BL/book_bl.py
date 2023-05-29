import DL.base_dl as base_dl

def get_list_books(name_book):
    books = base_dl.get_data('books', {'name': {'$regex': name_book, '$options': 'i'}}, {})
    return books

def get_list_book_borrow_by_user_id(user_id):
    books = base_dl.get_data('books', {'borrower':user_id})
    return books