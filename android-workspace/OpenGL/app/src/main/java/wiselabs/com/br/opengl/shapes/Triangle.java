package wiselabs.com.br.opengl.shapes;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import wiselabs.com.br.opengl.GLRenderImpl;

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

    /**
     * Desenha usando OpenGL requer a definição de alguns detalhes oara renderizacao grafica
     * Alguns detalhes sao
     * Vertex Shader - OpenGL ES graphics code for rendering the vertices of a shape.
     * Fragment Shader - OpenGL ES code for rendering the face of a shape with colors or textures.
     * Program - An OpenGL ES object that contains the shaders you want to use for drawing one or more shapes.
     * */

    /*
    * Eh necessario ao menos 1 vertexShader para desenhar a forma e 1 fragmentShader para a cor da forma
    * */
    private static final String vertexShaderCode = "attribute vec4 vPosition; void main() {l_Position = vPosition;}";
    private static final String fragmentShaderCode = "precision mediump float; uniform vec4 vColor; void main() {gl_FragColor = vColor;}";

    private final int compiledShader;

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

        int verTexShader = GLRenderImpl.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = GLRenderImpl.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
        // criando um OpenGL ES program vazio
        compiledShader = GLES20.glCreateProgram();
        GLES20.glAttachShader(compiledShader, verTexShader);
        GLES20.glAttachShader(compiledShader, fragmentShader);
        // criando um OpenGL ES program executavel
        GLES20.glLinkProgram(compiledShader);
    }

    public void draw(GL10 gl) {

    }

    public void deaw(float[] matrix) {

    }
}
