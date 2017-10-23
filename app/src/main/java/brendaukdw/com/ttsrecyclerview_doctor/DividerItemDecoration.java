package brendaukdw.com.ttsrecyclerview_doctor;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Brenda on 23/10/2017.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration{
    private static final int[] decor = new int[]{
            android.R.attr.listDivider
    };

    public static final int horizontalList = LinearLayoutManager.HORIZONTAL;
    public static final int verticalList = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;
    private int mOrientation;
    public DividerItemDecoration(Context context, int orientation){
        final TypedArray a = context.obtainStyledAttributes(decor);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }
    public void setOrientation(int orientation){
        if(orientation != horizontalList && orientation!= verticalList){
            throw new IllegalArgumentException("Invalid orientation");
        }
        mOrientation = orientation;
    }
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state){
        if (mOrientation == verticalList){
            drawVertical(c, parent);
        }
        else{
            drawHorizontal(c, parent);
        }
    }
    public void drawVertical(Canvas c, RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth();
        parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for(int i =0; i < childCount; i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
    public void drawHorizontal(Canvas c, RecyclerView parent){
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight();
        parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for(int i = 0; i<childCount; i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation == verticalList){
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
        }
        else {
            outRect.set(0,0,mDivider.getIntrinsicWidth(),0);
        }
    }
}
