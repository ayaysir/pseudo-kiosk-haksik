http://yoonbumtae.com/?p=3167

#### **제작 연도**

2018  

#### **사용기술**

Java(Swing UI + 네트워크 소켓), CSV  

#### **제작 목적**

프로그래밍 학습과 더불어, POS 및 KIOSK 원리 파악의 목적을 위해 제작하였습니다.  

#### **프로젝트 구조**

![](http://yoonbumtae.com/wp-content/uploads/2020/11/customer.png) \
클라이언트 : 고객(KIOSK 기계)

![](http://yoonbumtae.com/wp-content/uploads/2020/11/prop_example.png) \
kiosk.properties 예제

![](http://yoonbumtae.com/wp-content/uploads/2020/11/kitchen.png) \
클라이언트 : 주방

![](http://yoonbumtae.com/wp-content/uploads/2020/11/server.png) \
서버 : 영양사실 

#### **주요 특징 및 스크린샷**

*   학식(학생식당)에서 사용할 수 있는 KIOSK 머신용 프로그램과 주방 프로그램, 관리 서버로 구성됨
*   Swing UI와 네트워크 소켓을 사용하여 제작
*   인터페이스 구현 방식 채택 - 메소드 기능 오버라이딩 가능
*   스레드의 동기화(synchronized) 적용으로 잘못된 주문 방지
*   여러 대의 키오스크 설치 가능
*   서버가 설치된 사무실(영양사실)에서 메뉴 관리 및 정산
*   자주 나오는 메뉴 세트를 CSV로 저장 및 불러오기 기능
*   주방에서 주문 메뉴 확인 가능
*   주방 구역(분식구역, 한식구역, 양식구역 등) 설정 기능
*   식권 출력(발매) 기능
*   거스름돈 기능
*   메뉴 수량(재고) 관리 기능
*   메뉴 홍보 기능

![](http://yoonbumtae.com/wp-content/uploads/2020/11/1.png) \키오스크 화면 - 메뉴 주문, 합계 표시, 메뉴 홍보
![](http://yoonbumtae.com/wp-content/uploads/2020/11/2-2.png) \식권 발매 성공 화면
![](http://yoonbumtae.com/wp-content/uploads/2020/11/2.png) \가상 현금결제 상황 구현 - 기계와 연동한 경우 실제 현금결제 가능
![](http://yoonbumtae.com/wp-content/uploads/2020/11/3.png) \거스름돈 제공 알고리즘 구현
![](http://yoonbumtae.com/wp-content/uploads/2020/11/4.png) \식권 발매 - 프린터가 연결된 경우 실제 출력 가능  
![](http://yoonbumtae.com/wp-content/uploads/2020/11/5.png) \
![](http://yoonbumtae.com/wp-content/uploads/2020/11/6.png) \수량 제한 기능, 재고 알림 기능
![](http://yoonbumtae.com/wp-content/uploads/2020/11/7.png) \결제가 완료된 경우 키오스크 화면 초기화 및 재고상황 반영
![](http://yoonbumtae.com/wp-content/uploads/2020/11/8.png) \주방 관리 프로그램 - 남은 수량 및 진행상황 반영 기능
![](http://yoonbumtae.com/wp-content/uploads/2020/11/9.png) \요일별 메뉴 (CSV) 파일 불러오기
![](http://yoonbumtae.com/wp-content/uploads/2020/11/10.png) \수량 관리 기능 및 판매 통계, 정산 기능
![](http://yoonbumtae.com/wp-content/uploads/2020/11/csv_example.png) \메뉴 CSV 파일
