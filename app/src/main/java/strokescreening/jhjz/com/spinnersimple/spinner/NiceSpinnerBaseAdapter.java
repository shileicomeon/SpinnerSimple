package strokescreening.jhjz.com.spinnersimple.spinner;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import strokescreening.jhjz.com.spinnersimple.R;


public abstract class NiceSpinnerBaseAdapter<T> extends BaseAdapter {

    private final SpinnerTextFormatter spinnerTextFormatter;

    private int textColor;
    private int backgroundSelector;
    int selectedIndex;
    private final Resources resources;

    protected NiceSpinnerBaseAdapter(Context context, int textColor, int backgroundSelector,
                                     SpinnerTextFormatter spinnerTextFormatter) {
        this.spinnerTextFormatter = spinnerTextFormatter;
        this.backgroundSelector = backgroundSelector;
        this.textColor = textColor;
        resources = context.getResources();
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        TextView textView;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.spinner_list_item, null);
            textView = (TextView) convertView.findViewById(R.id.text_view_spinner);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                textView.setBackground(ContextCompat.getDrawable(context, backgroundSelector));
            }
            convertView.setTag(new NiceSpinnerBaseAdapter.ViewHolder(textView));
        } else {
            textView = ((NiceSpinnerBaseAdapter.ViewHolder) convertView.getTag()).textView;
        }
        int defaultPadding = resources.getDimensionPixelSize(R.dimen.one_and_a_half_grid_unit);
        textView.setPadding(resources.getDimensionPixelSize(R.dimen.three_grid_unit),defaultPadding,defaultPadding,defaultPadding);
        textView.setText(spinnerTextFormatter.format(getItem(position).toString()));
        textView.setTextColor(textColor);
        return convertView;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int index) {
        selectedIndex = index;
    }

    public abstract T getItemInDataset(int position);

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract T getItem(int position);
    @Override
    public abstract int getCount();

    public static class ViewHolder {
        TextView textView;
        public ViewHolder(TextView textView) {
            this.textView = textView;
        }
    }

}
