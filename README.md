# java-chicken again

## 필요 기능

포스기의 기능에는 주문 등록, 결제하기, 종료가 있다.

메뉴는 번호, 종류, 이름, 가격으로 이루어져 있다.

테이블은 고유의 테이블 번호가 있다(현 요구사항에서는 1, 2, 3, 5, 6, 8)

테이블은 주문이 들어갔다면 별도로 ₩ 표시를 한다.

주문은 한 메뉴당 최대 99개까지 주문할 수 있다.

결제는 치킨 종류 10개 당 10,000원 할인이 들어간다.
추가로 현금으로 결제시 5%의 중복할인도 가능하다. 

올바르지 않은 입력으로 주문, 결제 실패시 사용자에게 다시 물어보도록 구성한다.

최종 결제금액을 표시한다.

## 세부 구현 과정

### Amount


### Order


### Orders


### Table


### Tables


### PaymentCalculator


### DiscountableByCategory    


### ChickenDiscountStrategy 
 

### PaymentType
  

### CardDiscountStrategy  
   
