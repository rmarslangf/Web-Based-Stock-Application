<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a id="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->




<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="images/logo.png" alt="Logo" width="80" height="80">


  <h3 align="center">Web Based Stock Application</h3>

  <p align="center">
    Web based stock application which change the understanding of web applications
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents/İçerik</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li><a href="#usage">Usage</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project | Proje Hakkında


🇬🇧 I developed a comprehensive stock management web application that allows users to add, sell, and track products, visualize stock levels, and analyze profits through interactive charts. This project showcases my skills in API development, database design, and creating seamless user experiences.

🇹🇷 Ürün ekleme, satış, stok takibi ve kâr analizlerini interaktif grafiklerle sunan kapsamlı bir stok yönetim web uygulaması geliştirdim. Bu proje, API geliştirme, veritabanı tasarımı ve kullanıcı dostu arayüzler oluşturmadaki yetkinliğimi ortaya koymaktadır.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

### 🛠️ Built With | Kullanılan Teknolojiler

<!-- JAVA -->
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com)

<!-- SPRING -->
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io)

<!-- POSTGRESQL -->
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org)

<!-- DOCKER -->
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com)

<!-- KUBERNETES -->
[![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)](https://kubernetes.io)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 🚀 Getting Started | Başlarken

🇬🇧 This project is available in **two distinct architectures**:  
1. `stock/` → A **monolithic** Java Spring Boot application  
2. `microservice-stock/` → A **distributed microservices-based** architecture  

Each version is designed for different use cases and scalability needs.

🇹🇷 Bu proje **iki farklı mimariyle** sunulmaktadır:  
1. `stock/` → Tek parça çalışan **monolitik** bir Java Spring Boot uygulaması  
2. `microservice-stock/` → Dağıtık yapılara uygun **mikroservis mimarisi**  

Her versiyon farklı ihtiyaçlar ve ölçekleme senaryoları için uygundur.

---

### 🧱 Monolithic Version (`stock/`) | Monolitik Versiyon

🇬🇧 This version is built as a single Spring Boot application. All components are bundled together.

🇹🇷 Bu versiyon tüm bileşenleri tek bir yapı altında barındıran, tek uygulama olarak çalışan bir Spring Boot sistemidir.

✅ Ideal for | İdeal kullanım:
- Simple deployments | Basit dağıtımlar
- Solo or small teams | Küçük ekipler ya da bireysel projeler
- Minimal setup | Minimum yapılandırma ihtiyacı

---

### 🧩 Microservices Version (`microservice-stock/`) | Mikroservis Versiyon

🇬🇧 A distributed architecture where services like Inventory, Sales, and Analytics run independently, communicating via REST or queues.

🇹🇷 Envanter, Satış, Analiz gibi bileşenlerin birbirinden bağımsız servisler olarak çalıştığı dağıtık bir yapıdır. Servisler REST API veya mesaj kuyrukları üzerinden haberleşir.

✅ Ideal for | İdeal kullanım:
- CI/CD pipelines | CI/CD senaryoları
- Large-scale apps | Büyük projeler
- Kubernetes environments | K8s altyapıları

---

## 🧪 Usage | Kullanım

---

### 🧱 Monolithic (`stock/`) | Monolitik Kullanım

🇬🇧 To run the application:

```bash
cd stock
./mvnw spring-boot:run
```
🇹🇷 Uygulamayı çalıştırmak için:
```bash
cd stock
./mvnw spring-boot:run
```
☸️ Microservices (microservice-stock/) | Mikroservis Kullanımı
🇬🇧 Kubernetes environment required. To run:

```bash
kubectl apply -f k8s/
This will deploy:
```
All services (Inventory, Sales, Analytics)

PostgreSQL as a stateful service

🇹🇷 Kubernetes ortamı gereklidir. Çalıştırmak için:

```bash
kubectl apply -f k8s/
Bu işlemle:
```
Tüm servisler (Envanter, Satış, Analiz)

PostgreSQL (stateful service olarak)


☸️ Make sure your cluster is up and kubectl is configured.
☸️ Kümenizin çalışır durumda olduğundan ve kubectl’ün yapılandırıldığından emin olun.

<p align="right">(<a href="#readme-top">back to top</a>)</p> ```
