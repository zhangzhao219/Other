import os
from flask import Flask
def create_app():
    app = Flask(__name__,instance_relative_config=True) # instance_relative_config=True 告诉应用配置文件是相对于 instance folder 的相对路径
    app.config.from_mapping(
        SECRET_KEY='dev',
        DATABASE=os.path.join(app.instance_path, 'flaskr.sqlite'),
        ENV='development',
        DEBUG=True
    )
    # app.config.from_pyfile('settings.cfg')
    if not os.path.exists(app.instance_path):
        os.makedirs(app.instance_path)

    from . import db
    db.init_app(app)

    @app.route('/hello')
    def hello():
        return 'Hello, World!'

    return app