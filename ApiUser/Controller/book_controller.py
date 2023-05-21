from flask import Blueprint, request
import BL.book_bl as book_bl
from bson import json_util
import json
import DL.base_dl as base_dl

books = Blueprint('books', __name__, url_prefix='/books')


# @user_page.route('/')
# def user_index():
#     return "user index"

@books.route('findbook', methods=['GET'])
def find_book():
    name_book = request.args.get('name')
    list_book = book_bl.get_list_books(name_book)
    return json.loads(json_util.dumps(list_book))

@books.route('borrowbook', methods=['POST'])
def borrow_book():
    return ''

@books.route('getlistborrowbook', methods=['GET'])
def get_list_borrow_book():
    return ''