import BL.book_bl as book_dl
from flask import Blueprint, Response
import DL.base_dl as base_dl
from common import ulti, enum


books = Blueprint('books', __name__, url_prefix='/books')

@books.route('/list-book', methods=['GET'])
def get_list_books(name_book):
    response = book_dl.get_list_books(name_book)
    return Response(response, enum.HTTP_STATUS.SUCCESS.value)

@books.route('/add_book', methods=['POST'])
def add_book(book):
    response = book_dl.add_book(book)
    return Response(response, status=enum.HTTP_STATUS.SUCCESS.value)

@books.route('/add-user-borrow', methods=['POST'])
def add_user_borrow(data):
    response = book_dl.add_user_borrow(data)
    return Response(response, enum.HTTP_STATUS.SUCCESS.value)
