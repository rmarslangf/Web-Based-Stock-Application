from flask import Flask, send_file
import psycopg2
import matplotlib.pyplot as plt
import seaborn as sns
import io

app = Flask(__name__)

@app.route('/')
def home():
    return "Hoş geldiniz! Kâr marjı grafiği için <a href='/graph'>buraya tıklayın</a>."

@app.route('/graph')
def graph():
    # Veritabanı bağlantı bilgileri
    db_params = {
        'dbname': 'registration',
        'user': 'postgres',
        'password': 'cd6319b505bb3',
        'host': 'localhost',
        'port': '5432'
    }

    # Veritabanına bağlanma
    conn = psycopg2.connect(**db_params)
    cursor = conn.cursor()

    # Ürün verilerini çekme
    cursor.execute("SELECT name, price, stock_quantity FROM products")
    products = cursor.fetchall()

    # Kâr marjı hesaplama (örnek olarak fiyatın %20'si)
    profit_margins = [price * 0.2 for _, price, _ in products]

    # Grafik oluşturma
    plt.figure(figsize=(10, 6))
    sns.barplot(x=[name for name, _, _ in products], y=profit_margins)
    plt.title('Kâr Marjı Grafiği')
    plt.xlabel('Ürün')
    plt.ylabel('Kâr Marjı')
    plt.xticks(rotation=45)
    plt.tight_layout()

    # Grafiği bir bellek akışına kaydetme
    img = io.BytesIO()
    plt.savefig(img, format='png')
    img.seek(0)
    plt.close()

    # Bağlantıyı kapatma
    cursor.close()
    conn.close()

    return send_file(img, mimetype='image/png')

@app.route('/live-profit-margin')
def live_profit_margin():
    # Veritabanı bağlantı bilgileri
    db_params = {
        'dbname': 'registration',
        'user': 'postgres',
        'password': 'cd6319b505bb3',
        'host': 'localhost',
        'port': '5432'
    }

    # Veritabanına bağlanma
    conn = psycopg2.connect(**db_params)
    cursor = conn.cursor()

    # Ürün verilerini çekme
    cursor.execute("SELECT name, price, stock_quantity FROM products")
    products = cursor.fetchall()

    # Kâr marjı hesaplama (örnek olarak fiyatın %20'si)
    profit_margins = [price * 0.2 for _, price, _ in products]

    # Grafik oluşturma
    plt.figure(figsize=(10, 6))
    sns.barplot(x=[name for name, _, _ in products], y=profit_margins)
    plt.title('Kâr Marjı Grafiği')
    plt.xlabel('Ürün')
    plt.ylabel('Kâr Marjı')
    plt.xticks(rotation=45)
    plt.tight_layout()

    # Grafiği bir bellek akışına kaydetme
    img = io.BytesIO()
    plt.savefig(img, format='png')
    img.seek(0)
    plt.close()

    # Bağlantıyı kapatma
    cursor.close()
    conn.close()

    return send_file(img, mimetype='image/png')

if __name__ == '__main__':
    app.run(debug=True) 