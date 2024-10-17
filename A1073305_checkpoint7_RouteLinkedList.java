public class A1073305_checkpoint7_RouteLinkedList{
    private A1073305_checkpoint7_Node head;
    //Description : the constructor of leading the head Node as null.
    public A1073305_checkpoint7_RouteLinkedList(){
        this.head = null;
    }
    //Description : the constructor of input a Node as the head node.
    public A1073305_checkpoint7_RouteLinkedList(A1073305_checkpoint7_Node head){
        this.head = head;
    }
    public void delete(int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint5)******************************
        //TODO(1):      Input value of Node as the reference Node,
        //              you have to delete the first Node that is same as the reference Node,
        //              and connect the following one and the previous one.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073305_checkpoint7_Node prev =null;
        A1073305_checkpoint7_Node current = head;
        if(head == null)
        {
            System.out.println("list is empty!");
        }else{
            while((current.getAxis()!= axis || current.getDirection() != direction) && (current.getNext() != null))
            {
                prev = current;
                current = current.getNext();
            }
            if(current.getAxis() == axis && current.getDirection() == direction)
            {
                if(prev == null)head = current.getNext();
                else prev.setNext(current.getNext());  
            }else{
                System.out.println("No data in list!");
            }
        }    
        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }

    public A1073305_checkpoint7_Node search(int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint5)********************************
        //TODO(2):      Input value of Node as the reference Node,
        //              you have to find the first Node that is same as the reference Node,
        //              and return it.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073305_checkpoint7_Node prev = null;
        A1073305_checkpoint7_Node current = head;
        if(head == null)
        {
            return prev;
        }else{
            while((current.getAxis() != axis || current.getDirection() != direction) && (current.getNext() != null))
            {
            	prev = current;
                current = current.getNext();
            }
            if(current.getAxis() == axis && current.getDirection() == direction)
            {
                return current;
            }else{
                return null;
            }
        }
        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public void insert(int referenceAxis, int referenceDirection, int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint6)********************************
        //TODO(3):      Input value of Node as the reference Node,
        //              and insert a Node BEFORE the first Node same as the reference Node,
        //              and connect the following one and the previous one.
        //Hint          The value of the Node is int variable axis and dirsction.
        //Hint2         If there is no reference node in linkedlist, print "Insertion null".
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073305_checkpoint7_Node node = new A1073305_checkpoint7_Node(direction, axis);
        A1073305_checkpoint7_Node prev = null;
        A1073305_checkpoint7_Node current = head;
        if(head == null)
        {
            head = node;
        }
        else{
            while((current.getAxis() != referenceAxis || current.getDirection() != referenceDirection) && (current.getNext() != null))
            {
                prev = current;
                current=current.getNext();
            }
            if(prev == null)
            {
                node.setNext(current);
                head = node;
            }
            else if(current.getAxis() == referenceAxis && current.getDirection() == referenceDirection)
            {
                node.setNext(current);
                current.setNext(node);
            }
            else{
                System.out.println("Insertion null");
            }
        }


        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public int length(){
        /*********************************The Past TODO (Checkpoint5)********************************
        //TODO(4):      return how long the LinkedList is.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073305_checkpoint7_Node node = this.getHead();
        int count = 0;
        if(node == null)
        {
            return count;
        }
        else
        {
            count += 1;
            while(node.getNext() != null)
            {
                node = node.getNext();
                count += 1;
            }
            return count;
        }
        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public void append(int axis, int direction){
        // A1073305_checkpoint7_Node node = new A1073305_checkpoint7_Node (direction, axis) ;
        // A1073305_checkpoint7_Node current = head ;
        // if (head == null)
        //     head = node;
        // else{
        //     while (current.getNext() != null)
        //     {
        //         current = current.getNext();
        //     }
        //     current.setNext(node);
        // }
        A1073305_checkpoint7_Node node = this.head;
        if(head != null){
            while(node.getNext() != null){
                node = node.getNext();
            }
            node.setNext(new A1073305_checkpoint7_Node(direction, axis));
        }else{
            setHead(new A1073305_checkpoint7_Node(direction, axis));
        }

    }
    public A1073305_checkpoint7_Node getHead(){
        return this.head;
    }
    public void setHead(A1073305_checkpoint7_Node head){
        this.head = head;
    }
}
    

