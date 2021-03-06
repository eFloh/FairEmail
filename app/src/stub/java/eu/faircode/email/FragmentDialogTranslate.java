package eu.faircode.email;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FragmentDialogTranslate extends FragmentDialogBase {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getContext())
                .setTitle(R.string.title_translate)
                .create();
    }

    static void Translate(String text, String targetLanguage, ITranslate intf) {
        // Stub
    }

    interface ITranslate {
        void onTranslated(String language, String text);

        void onError(Throwable ex);
    }
}
