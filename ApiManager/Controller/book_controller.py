import BL.book_bl as book_dl
from flask import Blueprint, Response, request
import DL.base_dl as base_dl
from bson import json_util
from common import ulti, enum


books = Blueprint('books', __name__, url_prefix='/books')

'''
Lấy tất cả các sách
'''
@books.route('/list-book', methods=['GET'])
def get_list_books(name_book):
    response = book_dl.get_list_books(name_book)
    return Response(response, enum.HTTP_STATUS.SUCCESS.value)

'''
Thêm sách mới
'''
@books.route('/add_book', methods=['POST'])
def add_book():
    book = request.get_json()
    response = book_dl.add_book(book)
    return Response(response, status=enum.HTTP_STATUS.SUCCESS.value)

'''
Gắn người dùng mượn vào sách
'''
@books.route('/add-user-borrow', methods=['POST'])
def add_user_borrow():
    data = request.get_json()
    book = book_dl.add_user_borrow(data)
    response = json_util.dumps(book, default=json_util.default)
    return Response(response, enum.HTTP_STATUS.SUCCESS.value)

'''
Trả sách
'''
@books.route('/give-book-back', methods=['POST'])
def give_book_back(data):
    data = request.get_json()
    book = book_dl.give_book_back(data)
    response = json_util.dumps(book, default=json_util.default)
    return Response(response, enum.HTTP_STATUS.SUCCESS.value)

'''
Lấy danh sách các sách đang cho mượn
'''
@books.route('/get-list-borrow-book', methods=['GET'])
def get_list_borrow_book():
    books = book_dl.get_list_borrow_book()
    response = json_util.dumps(books, default=json_util.default)
    return Response(response, enum.HTTP_STATUS.SUCCESS.value)