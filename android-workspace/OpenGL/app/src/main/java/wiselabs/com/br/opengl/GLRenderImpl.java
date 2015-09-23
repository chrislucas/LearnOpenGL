package wiselabs.com.br.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by C.Lucas on 21/09/2015.
 */
public class GLRenderImpl implements GLSurfaceView.Renderer {

    /**
     * chamado quando a surface e criada ou recriada
     * */
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // red, green, blue, alpha
        // background frame color
        GLES20.glClearColor(0.0f,0.0f,0.0f,1.0f);
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
        GLES20.glViewport(0,0,width,height);
    }
}
