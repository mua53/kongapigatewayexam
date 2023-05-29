import json

def response_data_error(mess):
    return json.dumps({
        'error': True,
        'message': mess
    })

