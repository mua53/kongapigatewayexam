from flask import Flask, request
from flask import json
from werkzeug.exceptions import HTTPException
# from Controller.user_controller import users
# from Controller.book_controller import books

app = Flask(__name__)

# app.register_blueprint(users)
# app.register_blueprint(books)

@app.route('/')
def hello():
    return "This API for Manager"
