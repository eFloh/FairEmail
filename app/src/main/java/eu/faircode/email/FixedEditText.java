package eu.faircode.email;

/*
    This file is part of FairEmail.

    FairEmail is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FairEmail is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with FairEmail.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2018-2020 by Marcel Bokhorst (M66B)
*/

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class FixedEditText extends AppCompatEditText {
    public FixedEditText(@NonNull Context context) {
        super(context);
    }

    public FixedEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setSelection(int index) {
        try {
            super.setSelection(index);
        } catch (Throwable ex) {
            Log.e(ex);
            /*
                java.lang.IndexOutOfBoundsException: setSpan (2 ... 2) ends beyond length 0
                        at android.text.SpannableStringBuilder.checkRange(SpannableStringBuilder.java:1265)
                        at android.text.SpannableStringBuilder.setSpan(SpannableStringBuilder.java:684)
                        at android.text.SpannableStringBuilder.setSpan(SpannableStringBuilder.java:677)
                        at android.text.Selection.setSelection(Selection.java:76)
                        at android.widget.EditText.setSelection(EditText.java:96)
                        at android.widget.NumberPicker$SetSelectionCommand.run(NumberPicker.java:2246)
                        at android.os.Handler.handleCallback(Handler.java:754)
                        at android.os.Handler.dispatchMessage(Handler.java:95)
             */
        }
    }

    @Override
    public void setSelection(int start, int stop) {
        try {
            super.setSelection(start, stop);
        } catch (Throwable ex) {
            Log.e(ex);
        }
    }

    @Override
    public boolean performLongClick() {
        try {
            return super.performLongClick();
        } catch (Throwable ex) {
/*
            java.lang.IllegalStateException: Drag shadow dimensions must be positive
                    at android.view.View.startDragAndDrop(View.java:27316)
                    at android.widget.Editor.startDragAndDrop(Editor.java:1340)
                    at android.widget.Editor.performLongClick(Editor.java:1374)
                    at android.widget.TextView.performLongClick(TextView.java:13544)
                    at android.view.View.performLongClick(View.java:7928)
                    at android.view.View$CheckForLongPress.run(View.java:29321)
*/
            Log.w(ex);
            return false;
        }
    }
}
