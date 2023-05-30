import DL.user_dl as user_dl
import DL.base_dl as base_dl

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
    
def sign_up(user_data):
    if check_exits_user(user_data['username']):
        base_dl.insert_one_data('user', user_data)
        user = base_dl.get_data_one('user', {'username': user_data['username']})
        return user
    else:
        return None


def check_exits_user(user_name):
    user = base_dl.get_data_one('user', {'username': user_name})
    if user:
        return False
    else:
        return True
