public class Taxi extends Transport{
    String dest;        // 목적지
    int dist;           // 기본거리
    int dest_dist;      // 목적지까지 거리
    int basic_charge;   // 기본 요금
    int per_charge;     // 거리당 요금
    int total_charge;   // 총 요금

    public Taxi(){
        this("일반",4,3000,1000,1);
    }

    public Taxi(String state, int passenger, int basic_charge, int per_charge, int dist){
        super();                                // 주유량, 속도
        this.state = state;
        this.limit_passenger = passenger;
        this.basic_charge = basic_charge;
        this.per_charge = per_charge;
        this.dist = dist;
    }

    public void board(String dest, int passenger_num, int dest_dist){
        if(state.equals("일반") && this.current_passenger + passenger_num <= this.limit_passenger){
            this.dest = dest;
            this.dest_dist = dest_dist;
            this.current_passenger = this.current_passenger + passenger_num;
            this.state = "운행중";

            if(dest_dist > this.dist){
                add_charge(dest_dist);
            }{
                total_charge = basic_charge;
            }

        }else{
            System.out.println("인원수 초과로 탑승할 수 없습니다.");
        }
    }

    public void drive(int oil_vol){
        this.oil_vol = this.oil_vol - oil_vol;

        if(!check_oil()){
            System.out.println("주유가 필요합니다.");
        }
        else if(!check_drive()){
            change_state("운행불가");
        }
    }

    public void add_charge(int dest_dist){
        total_charge = basic_charge + (per_charge * dest_dist - this.dist);
    }

    public void stop(){
        change_state("운행불가");
    }

    public void payment(){
        System.out.printf("주유량 = %d\n", this.oil_vol);
        System.out.printf("누적 요금  = %d\n", this.total_charge);

        init("");
    }

    public void init(String dest){
        this.dest = dest;
        this.dest_dist = 0;
        this.current_passenger = 0;
        this.state = "일반";
    }

    public boolean check_drive(){
        if(oil_vol == 0){
            change_state("운행불가");
            System.out.println("주유가 필요합니다.");

            return false;
        }
        else{
            return true;
        }
    }
}
