package com.preccydev.directory.model;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.preccydev.directory.R;

import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_FIRSTNAME;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_LASTNAME;


public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryAdapter.MyViewHolder> {

    private Cursor mCursor;
    private Context mContext;

    final private DirectoryItemClickListener mOnclickListener;

    public interface DirectoryItemClickListener {
        void onDirectoryItemClick(int ClickedItemIndex);
    }

    public DirectoryAdapter(Context context, Cursor cursor, DirectoryItemClickListener OnclickListener) {
        this.mContext = context;
        this.mCursor = cursor;
        this.mOnclickListener = OnclickListener;
        //

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        int layoutIdForListDirectory = R.layout.contact_layout;

        View view = inflater.inflate(layoutIdForListDirectory, parent, shouldAttachToParentImmediately);
        MyViewHolder DirViewHolder = new MyViewHolder(view);

        return DirViewHolder;

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position))
            return;

        String FirstName = mCursor.getString(mCursor.getColumnIndex(COLUMN_FIRSTNAME));
        String LastName = mCursor.getString(mCursor.getColumnIndex(COLUMN_LASTNAME));
        String first = LastName.substring(0,1);
        String FullName = LastName + " " + FirstName;
        holder.mFullName.setText(FullName);
        holder.mTicker.setText(first);


    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        // Always close the previous mCursor first
        if (mCursor != null) mCursor.close();
        mCursor = newCursor;
        if (newCursor != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView mFullName;
        private TextView mHallOfResidence;
        private TextView mLevel;
        private TextView mPhoneNumber;
        private TextView mGender;
        private TextView mTicker;

        public MyViewHolder(View itemView) {
            super(itemView);

            mFullName = (TextView) (itemView).findViewById(R.id.full_name_text_view);
            mTicker = (TextView) (itemView).findViewById(R.id.ticker_text_view);
            itemView.setOnClickListener(this);
        }

       @Override
        public void onClick(View v) {
            int ClickItemPosition = getAdapterPosition();
            mOnclickListener.onDirectoryItemClick(ClickItemPosition);
        }
    }
}
