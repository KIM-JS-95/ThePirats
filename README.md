# 더 파이러츠 백엔드 개발자 채용 과제
## INDEX

A. [점포추가 API][점포추가-API]

B.  [점포 휴무일 등록 API][점포-휴무일-등록-API]

C. [점포 목록 조회 API][점포-목록-조회-API]

D. [점포 상세 정보 조회 API][점포-상세-정보-조회-API]

E. [점포 삭제 API][점포-삭제-API]

##과제 설명

    인어교주해적단은 수산시장내의 여러 점포들과 제휴를 맺어 고객들을 위한 서비스를 제공합
    니다. 오늘은 “인어수산” 점포와 “해적수산” 점포, 이 두 곳과 제휴를 맺었습니다. 해당 점포를
    고객에게 노출시키기 위해서는 점포를 등록해야 합니다. 점포의 정보로는 다음과 같습니다.

    {점포명, 대표자명, 주소,전화번호, 노출의 우선순위를 위한 등급, 점포 설명(코멘트)} 

    그리고 고객의 헛된 발걸음을 없애기 위해 점포의 영업시간, 휴무일을 등록합니다.
    고객들은 해당 점포의 상세 내용을 볼 수 있어야 하고, 상세 정보에는 점포의 기본 정보 외
    에 오늘, 내일, 모레 3일치의 영업시간이 포함됩니다. 
    또한 휴무일이라면 휴무라고 표시됩니다.

    마지막으로 제휴가 종료된 점포는 점포 목록에서 삭제되어야 합니다.

## 개발 API

###🍔 DB MODELING

<img src="https://user-images.githubusercontent.com/65659478/107150830-1a7e4280-69a3-11eb-99fd-6b194f0992e6.png" width="80%" height="50%"></img>

1:N 매핑으로 [점포 추가 API][점포추가-API] 할경우 동시적으로 BUSINESSTIMES 데이터 가 추가되도록 구성
테이블의 활용을 고려하여 양방향 보다는 단방향으로 구성함

###🍔 점포추가 API

i. 아래 두 점포의 요청 파라미터를 전달 받아 DB에 저장

 점포 등록시 id(Primary Key) 값은 자동 증가처리

 영업 시작 시간, 종료시간은 같을 수 없음.

ii. 요청 파라미터

<img src="https://user-images.githubusercontent.com/65659478/107150824-17835200-69a3-11eb-8e91-fc9a2799b537.png" height="30%"></img>










###🍔 점포 휴무일 등록 API

i. 영업일 외에 특별한 날을 휴무로 지정

 점포의 id(Primary Key) 값을 파라미터로 전달받아 저장

ii. 요청 파라미터

 인어수산(id : 1)의 휴무일은 2021-01-21(목), 2021-01-22(금)

<img src="https://user-images.githubusercontent.com/65659478/107150825-18b47f00-69a3-11eb-8310-03266af37e41.png" width="40%" height="30%"></img>





###🍔 점포 목록 조회 API

i. 점포명, 점포 설명, 영업상태(영업중/영업종료/휴무) 정보를 등급(level) 오름차순
으로 조회


 영업중(OPEN) : 영업 open time <= 현재시간 <= 영업 close time

 영업종료(CLOSE) : 현재시간 < 영업 open time, 현재시간 > 영업 close time

 휴무(HOLIDAY) : 오늘날짜가 해당 점포의 등록된 휴무일일 경우

ii. 응답

<img src="https://user-images.githubusercontent.com/65659478/107150826-19e5ac00-69a3-11eb-974d-6edbd42c8cb2.png" width="90%" height="30%"></img>



###🍔 점포 상세 정보 조회 API



 ~~  진행중











###🍔 점포 삭제 API

i. 제휴가 종료된 점포에 대해 삭제 처리







[점포추가-API]: (#🍔-점포추가-API)
[점포-휴무일-등록-API]: (#🍔-점포-휴무일-등록-API)
[점포-목록-조회-API]: (#🍔-점포-목록-조회-API)
[점포-상세-정보-조회-API]: (#🍔-점포-상세-정보-조회-API)
[점포-삭제-API]: (#🍔-점포-삭제-API)

