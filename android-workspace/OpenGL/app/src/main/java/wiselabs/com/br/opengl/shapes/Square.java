package wiselabs.com.br.opengl.shapes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by C.Lucas on 23/09/2015.
 */
public class Square {

    private Point points[];
    private FloatBuffer vertexBuffer;
    private ShortBuffer drawListBuffer;
    private static short drawOrder[] = {0,1,2,0,2,3};
    private float[] formCoordenates;

    /**
     * A tecnica usada aqui para desenha um quadrado
     * eh desenhar 2 triangulos lado a lado
     * com o vertices (0 1 2) formando o lado esquerdo do quandrdo
     * e os vertices (0 2 3) o lado direito
     * */

    public Square(Point points[]) {
        this.points = points;
        this.formCoordenates = new float[points.length * 3];

        ByteBuffer bbuffer = ByteBuffer.allocate(points.length * 12);
        bbuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = bbuffer.asFloatBuffer();
        initVertexBuffer();
        vertexBuffer.put(this.formCoordenates);
        vertexBuffer.position(0);

        // inicializar buffer de butes para desenhar
        // passado por parametro o vetor com a ordem dos vertices a serem
        // desenhados vezes 2 que eh o tamanho em butes de uma variavel tipo short
        ByteBuffer buffer = ByteBuffer.allocate(drawOrder.length * 2);
        buffer.order(ByteOrder.nativeOrder());
        drawListBuffer = buffer.asShortBuffer();
        drawListBuffer.put(drawOrder);
        drawListBuffer.position(0);
    }

    private void initVertexBuffer() {
        int i=0;
        for(Point p : this.points) {
            this.formCoordenates[i++] = p.getX();
            this.formCoordenates[i++] = p.getY();
            this.formCoordenates[i++] = p.getZ();
        }
        return;
    }

    public void draw(GL10 gl) {

    }

    public void deaw(float[] matrix) {

    }
}
