package com.example.portfolio.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.portfolio.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback {

    List<PortfolioItem> mdata;
    RecyclerView rv_portfolio;
    PortfolioAdapter portfolioAdapter ;



    public PortfolioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio = view.findViewById(R.id.rv_portfolio);
        // create a list of portfolio items
        mdata = new ArrayList<>();


        mdata.add(new PortfolioItem(R.drawable.kartina1));
        mdata.add(new PortfolioItem(R.drawable.kartina2));
        mdata.add(new PortfolioItem(R.drawable.kartina3));
        mdata.add(new PortfolioItem(R.drawable.kartina4));
        mdata.add(new PortfolioItem(R.drawable.kartina5));
        mdata.add(new PortfolioItem(R.drawable.kartina6));
        mdata.add(new PortfolioItem(R.drawable.kartina7));
        mdata.add(new PortfolioItem(R.drawable.kartina8));
        mdata.add(new PortfolioItem(R.drawable.kartina9));


        portfolioAdapter = new PortfolioAdapter(mdata,this);

        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_portfolio.setAdapter(portfolioAdapter);

    }

    @Override
    public void onPortfolioItemClick(int pos) {

        PortfolioFragmentDetails portfolioFragmentDetails =
                new PortfolioFragmentDetails();

        Bundle bundle = new Bundle();
        bundle.putSerializable("object",mdata.get(pos));
        portfolioFragmentDetails.setArguments(bundle);


        portfolioFragmentDetails.show(getActivity().getSupportFragmentManager(),"tagname");






    }
}