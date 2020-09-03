package android.Isi.com;

public class Pregunta {
        private int textId;
        private boolean respuesta;

    public Pregunta(int textId, boolean respuesta) {
        this.textId = textId;
        this.respuesta = respuesta;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
}

