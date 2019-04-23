package structures;

public class RedBlackNode<K>{    

    RedBlackNode<K> left, right;

    double element;

    int color;



    /* Constructor */

    public RedBlackNode(double theElement)

    {

        this( theElement, null, null );

    } 

    /* Constructor */

    public RedBlackNode(double theElement, RedBlackNode<K> lt, RedBlackNode<K> rt)

    {

        left = lt;

        right = rt;

        element = theElement;

        color = 1;

    }    

}