public class Bus extends Transport{

    //default constructor
    public Bus(){
        this("운행",30,1000);
    }

    public Bus(String state, int limit_passenger, int charge){
        super();
        this.state = "운행";
        this.limit_passenger = 30;
        this.charge = 1000;
    }

    public void board(int passenger_num){
        if(state.equals("운행") && this.current_passenger + passenger_num <= this.limit_passenger){
            this.current_passenger = this.current_passenger + passenger_num;
        }else{
            System.out.println("인원수 초과로 탑승할 수 없습니다.");
        }
    }

    public void drive(int oil_vol){
        this.oil_vol = this.oil_vol - oil_vol;

        if(!check_oil()){
            System.out.println("주유가 필요합니다.");
        }
        else if(this.oil_vol == 0){
            change_state("차고지행");
        }
    }

    public void stop(){
        change_state("차고지행");
    }
}
