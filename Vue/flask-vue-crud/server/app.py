import uuid
from flask import Flask, jsonify, request
from flask_cors import CORS
from eval import getLabels


BOOKS = [
    {
        'id': uuid.uuid4().hex,
        'Corpora': '中央经济工作会议指出，政府将更加有预见性地加强和改善宏观调控。以下属于我国宏观调控的主要目标有①促进经济增长②扩大出口③稳定物价④保持人民币汇率稳定A①②B①④C①③D③④',
        'Labels': '公民道德与伦理常识 社会主义市场经济的伦理要求 劳动就业与守法经营',
    },
    {
        'id': uuid.uuid4().hex,
        'Corpora': '蒋廷黻说：“洪秀全得到南京以后，我们更能看出他的真实心志不在建设新国家或新社会，而在建设新朝代。”太平天国运动中能支持该论断的是（）A.拒绝英国列强的要求B.平分土地实行圣库制度C.等级森严的官制规定D.洪仁轩提出《资政新篇》',
        'Labels': '近代史 清末民主革命风潮',
    },
]

# configuration
DEBUG = True

# instantiate the app
app = Flask(__name__)
app.config.from_object(__name__)

# enable CORS
CORS(app, resources={r'/*': {'origins': '*'}})


# sanity check route
@app.route('/ping', methods=['GET'])
def ping_pong():
    return jsonify('pong!')


def remove_book(book_id):
    for book in BOOKS:
        if book['id'] == book_id:
            BOOKS.remove(book)
            return True
    return False


@app.route('/books', methods=['GET', 'POST'])
def all_books():
    response_object = {'status': 'success'}
    if request.method == 'POST':
        post_data = request.get_json()
        BOOKS.append({
            'id': uuid.uuid4().hex,
            'Corpora': post_data.get('Corpora'),
            'Labels': getLabels(post_data.get('Corpora')),
        })
        response_object['message'] = 'Corpora added!'
    else:
        response_object['books'] = BOOKS
    return jsonify(response_object)


@app.route('/books/<book_id>', methods=['PUT', 'DELETE'])
def single_book(book_id):
    response_object = {'status': 'success'}
    if request.method == 'PUT':
        post_data = request.get_json()
        remove_book(book_id)
        BOOKS.append({
            'id': uuid.uuid4().hex,
            'Corpora': post_data.get('Corpora'),
            'Labels': getLabels(post_data.get('Corpora')),
        })
        response_object['message'] = 'Corpora updated!'
    if request.method == 'DELETE':
        remove_book(book_id)
        response_object['message'] = 'Corpora removed!'
    return jsonify(response_object)


if __name__ == '__main__':
    app.run()
