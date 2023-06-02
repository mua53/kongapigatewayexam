from flask import Blueprint, request, Response
import BL.book_bl as book_bl
from bson import json_util
import json
import DL.base_dl as base_dl
from common import ulti, enum

books = Blueprint('books', __name__, url_prefix='/books')


# @user_page.route('/')
# def user_index():
#     return "user index"

@books.route('findbook', methods=['GET'])
def find_book():
    name_book = request.args.get('name')
    list_book = book_bl.get_list_books(name_book)
    return json.loads(json_util.dumps(list_book))

@books.route('get-list-borrow-book/<string:user_id>', methods=['GET'])
def get_list_borrow_book(user_id):
    list_book = book_bl.get_list_book_borrow_by_user_id(user_id)
    response = json.dumps(list_book, default=json_util.default)
    return Response(response=response, mimetype="application/json", status=enum.HTTP_STATUS.SUCCESS.value)
