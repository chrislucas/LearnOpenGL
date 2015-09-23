package wiselabs.com.br.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by C.Lucas on 21/09/2015.
 */
public class FrameSurfaceView extends GLSurfaceView {

    private GLRenderImpl renderImpl;

    public FrameSurfaceView(Context context) {
        super(context);
        // cria um contexto OpenGL 2.0
        setEGLContextClientVersion(2);
        renderImpl = new GLRenderImpl();
        setRenderer(renderImpl);
        // desenhar ou redesenhar a view somente quando ha uma mudanca no conteudo desenhado
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
