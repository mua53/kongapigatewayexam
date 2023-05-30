from flask import Blueprint, render_template, abort, request, Response
import BL.user_bl as user_bl
from bson import json_util
import json
from common import ulti, enum



users = Blueprint('users', __name__, url_prefix="/user")


@users.route('/login', methods=['POST'])
def login():
    user_data = request.get_json()
    user = user_bl.get_user(user_data)
    if user:
        response = json.dumps(user, default=json_util.default)
        return Response(response=response, mimetype="application/json", status=enum.HTTP_STATUS.SUCCESS.value)
    else:
        response = ulti.response_data_error("username or password is incorrect")
        return Response(response, enum.HTTP_STATUS.AUTHOR.value)

@users.route('/signup', methods=['POST'])
def sign_up():
    user_signup = request.get_json()
    user = user_bl.sign_up(user_signup)
    if user:
        response = json_util.dumps(user, default=json_util.default)
        return Response(response=response, mimetype="application/json", status=enum.HTTP_STATUS.SUCCESS.value)
    else:
        response = ulti.response_data_error("Username already exists")
        return Response(response=response, status=enum.HTTP_STATUS.SUCCESS.value)



