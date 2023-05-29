import BL.user_bl as user_bl
from flask import Blueprint, Response, request
import DL.base_dl as base_dl
from common import ulti, enum

users = Blueprint('users', __name__, url_prefix="/user")


@users.route('/login', methods=['POST'])
def login():
    user_data = request.data
    user = user_bl.get_user(user_data)
    if user:
        return Response(response=user, status=enum.HTTP_STATUS.SUCCESS.value)
    else:
        response = ulti.response_data_error("username or password is incorrect")
        return Response(response, enum.HTTP_STATUS.AUTHOR.value)