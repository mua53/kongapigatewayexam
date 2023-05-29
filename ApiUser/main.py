from flask import Flask, Response
from Controller.user_controller import users
from Controller.book_controller import books
from werkzeug.exceptions import HTTPException
import common.ulti as ultis


app = Flask(__name__)

app.register_blueprint(users)
app.register_blueprint(books)

@app.route('/')
def hello():
    return "This API for User"

@app.errorhandler(404)
def page_not_found(e):
    response = ultis.response_data_error("Not have API")
    return Response(response,status=404)

@app.handle_exception(Exception)
def handle_exception(e):
    if isinstance(e, HTTPException):
        return e
    
    

if __name__ == '__main__':
    app.run(port=5000)
