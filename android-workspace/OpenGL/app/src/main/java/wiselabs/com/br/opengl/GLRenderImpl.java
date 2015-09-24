package wiselabs.com.br.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import wiselabs.com.br.opengl.shapes.Point;
import wiselabs.com.br.opengl.shapes.Square;
import wiselabs.com.br.opengl.shapes.Triangle;

/**
 * Created by C.Lucas on 21/09/2015.
 */
public class GLRenderImpl implements GLSurfaceView.Renderer {


    private Square square;
    private Triangle triangle;

    /**
     * chamado quando a surface e criada ou recriada
     * */
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // red, green, blue, alpha
        // background frame color
        GLES20.glClearColor(0.0f,0.0f,0.0f,1.0f);

        /**
         * O centro do GLSurfaceView eh (x,y,z)[(0,0,0)]
         * (1,1,0) eh o topo direito
         * (-1,1,0) eh o topo esquerdo
         * (-1,-1,0) eh o baixo esquerdo
         * (1,1,0) eh o baixo direito
         * */

        Point topLeft, bottomLeft, bottomRight, topRight;
        topLeft = new Point(-0.5f, 0.5f, 0.0f);
        bottomLeft = new Point(-0.5f, -0.5f, 0.0f);
        bottomRight = new Point(0.5f, -0.5f, 0.0f);
        topRight = new Point(0.5f, 0.5f, 0.0f);

        Point [] coordSquare = {topLeft, bottomLeft, bottomRight, topRight};

        square = new Square();
        triangle = new Triangle(coordSquare);
    }

    /*
    *  responsavel por desenhar o frame atual
    * */

    @Override
    public void onDrawFrame(GL10 gl) {
        // redraw bg color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
    /*
    * Called if the geometry of the view changes,
    * for example when the device's screen orientation changes
    * */
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }
    /**
     * Os shaders (sombreamento) contem uma linguagem OpenGL Shading LANGUAGE (GLSL)
     * essa linguagem precisa ser compilada para que possa ser usado OpenGL ES Enviroment
     * O Codigo abaixo faz esse trampo
     * */

    public static int loadShader(int type, String shaderCode) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }
}
