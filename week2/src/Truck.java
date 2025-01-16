import java.util.Scanner;

public class Truck{
    public static void main(String[] args){
        int N,W,L;
        QueueMethod QM = new QueueMethod();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = sc.nextInt();
        L = sc.nextInt();
        int[] Node = new int[N];
        for(int i=0;i<N;i++){
            Node[i] = sc.nextInt();
        }
        int TotalWeight = 0, idx = 0, time = 0;
        while(true){
            if(time != 0) {
                if (QM.peek().getUnitDistance() == W) {
                    //System.out.print("pop!");
                    //System.out.println(QM.peek().getWeight());
                    TotalWeight -= QM.pop().getWeight();
                    }
            }
            if(QM.isEmpty() && idx == N) break;
            if(idx!=N) {
                if (TotalWeight + Node[idx] <= L) {
                    TotalWeight += Node[idx];
                    QM.push(Node[idx++]);
                    //System.out.print("push!");
                    //System.out.println(QM.front.getWeight());
                }
            }
            QueueNode queueNode = QM.peek();
            while(true){
                queueNode.IncreaseUnitDistance(1);
                //System.out.print(queueNode.getWeight());
                //System.out.println(queueNode.getUnitDistance());
                if(queueNode.NextNode() == null){
                    break;
                }
                queueNode = queueNode.NextNode();
            }
            time++;
        }
        time += 1;
        System.out.println(time);
    }
}

class QueueNode {
    int weight; //값
    QueueNode queueNode; //다음 노드
    int UnitDistance;

    public QueueNode(int values) {
        this.weight = values;
        queueNode = null;
        this.UnitDistance = 0;
    }
    public int getUnitDistance(){
        return this.UnitDistance;
    }
    public int getWeight(){
        return this.weight;
    }
    public void IncreaseUnitDistance(int L){
        this.UnitDistance += L;
    }
    public QueueNode NextNode(){
        return this.queueNode;
    }
    public void setNextNode(QueueNode queueNode){
        this.queueNode = queueNode;
    }
}

class QueueMethod{
    QueueNode front, rear;
    public QueueMethod(){
        front = rear = null;
    }
    public boolean isEmpty(){
        return rear==null;
    }
    public void push(int values){
        QueueNode queueNode = new QueueNode(values);
        if(isEmpty()){
            front = rear = queueNode;
        }
        else {
            front.setNextNode(queueNode);
            front = queueNode;
        }
    }
    public QueueNode pop(){
        if(isEmpty()){
            return null;
        }
        else {
            QueueNode popNode = rear;
            rear = rear.NextNode();
            return popNode;
        }
    }
    public QueueNode peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return rear;
        }
    }
}