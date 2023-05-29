import DL.base_dl as base_dl
from bson.objectid import ObjectId

def get_user(user_data):
    query = {
        "username": user_data["username"],
        "password": user_data["password"]
    }
    user = base_dl.get_data_one('user',query)
    if (user):
        return user
    else:
        return None


def check_exits_user(user_name):
    user = base_dl.get_data_one('user', {'username': user_name})
    if user:
        return False
    else:
        return True
