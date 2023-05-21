from flask import Blueprint, render_template, abort, request, Response
from jinja2 import TemplateNotFound
import BL.user_bl as user_bl
from bson import json_util
import json


users = Blueprint('users', __name__, url_prefix="/user")


# @user_page.route('/')
# def user_index():
#     return "user index"

@users.route('/login', methods=['POST'])
def login():
    user_data = request.data
    user = user_bl.get_user(user_data)
    return user

@users.route('/signup', methods=['POST'])
def sign_up():
    user_signup = request.get_json()
    user = user_bl.sign_up(user_signup)
    if user:
        return json.loads(json_util.dumps(user))
    else:
        return 'Fail'


