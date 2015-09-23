package wiselabs.com.br.opengl.shapes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by C.Lucas on 23/09/2015.
 */
public class Triangle {

    private FloatBuffer vertexBuffer;

    static final int COORDS_PER_VERTEX = 3;
    static float[] formCoordenates = {
        0.0f, 0.622008459f, 0.0f        //top
        ,-0.5f, -0.311004243f, 0.0f      // bottom
        ,0.5f, -0.344004243f, 0.0f       // bottom right
    };
    static float[] color = {0.63671875f, 0.76953125f, 0.22265625f, 0.75f}; //RGBA

    public Triangle() {
        // inicializando o vetor de bytes para a forma que sera desenha
        // tamanho do vetor de coordenadas * 4 butes para cada float
        ByteBuffer bbuffer = ByteBuffer.allocateDirect(formCoordenates.length * 4);
        // Hardware ByteOrder
        bbuffer.order(ByteOrder.nativeOrder());
        this.vertexBuffer = bbuffer.asFloatBuffer();
        this.vertexBuffer.put(formCoordenates);
        // definindo o buffer para posicao zero para ser lido a primeira coordenada
        this.vertexBuffer.position(0);
    }

}
