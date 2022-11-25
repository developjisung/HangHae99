public class Transport {
    int current_passenger;  // 현재 승객 수
    int limit_passenger;    // 최대 승객 수 (한도)
    int charge;             // 요금
    int car_num;            // 차번호
    int oil_vol;            // 주유량
    int speed;              // 속도
    String state;           // 상태

    // Default Constructor
    public Transport(){
        this.oil_vol = 100;
        this.speed = 0;
    }

    // 속도 변경
    public void change_speed(int speed){
        if(check_oil()){
            this.speed = this.speed + speed;
        }
        else{
            System.out.println("주유량을 확인해 주세요.");
        }
    }

    // 운행 종료
    public void stop(){
    }

    // 상태 변경
    public void change_state(String state){
        this.state = state;
    }

    // 주유량 확인
    public boolean check_oil(){
        if(this.oil_vol >= 10){
            return true;
        }
        else{
            return false;
        }
    }

    // 기름 사용
    public void refuel(int oil_vol){
        this.oil_vol = this.oil_vol + oil_vol;
    }

    // 승객 탑승
    public void board(){
    }
}
