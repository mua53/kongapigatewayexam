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

@app.errorhandler(400)
def error_404(e):
    response = ultis.response_data_error("Bad request")
    return Response(response,status=404)
    

if __name__ == '__main__':
    app.run(port=5000)
