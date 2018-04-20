package project.dajver.com.cartviewwithbadge;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    public Activity context;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        onViewCreated(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getViewId(), container, false);
        ButterKnife.bind(this, rootView);
        setHasOptionsMenu(true);
        return rootView;
    }

    public abstract int getViewId();
    public abstract void onViewCreated(View view);
}