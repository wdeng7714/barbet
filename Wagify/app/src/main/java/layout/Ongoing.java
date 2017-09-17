package layout;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.angelachang.wagify.FriendlyWager;
import com.example.angelachang.wagify.R;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Ongoing.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Ongoing#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ongoing extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Ongoing() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ongoing.
     */
    // TODO: Rename and change types and number of parameters
    public static Ongoing newInstance(String param1, String param2) {
        Ongoing fragment = new Ongoing();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ongoing, container, false);
//        ListView li = (ListView) v.findViewById(R.id.ongoingList);
//        ArrayList detailsArray = new ArrayList<String>();
//        ArrayAdapter adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, detailsArray);
//        li.setAdapter(adapter);
        LinearLayout parent = (LinearLayout) v.findViewById(R.id.LinearCardLayout);

        FriendlyWager fw = new FriendlyWager(5.0, "16/09/17", "Win the hackathon", "Testing", new ArrayList<String>(Arrays.asList("Angela", "Wendy")));
        parent.addView(makeCard(fw));
        parent.addView(makeCard(fw));
        parent.addView(makeCard(fw));
        parent.addView(makeCard(fw));
        parent.addView(makeCard(fw));
        parent.addView(makeCard(fw));
        parent.addView(makeCard(fw));
        parent.addView(makeCard(fw));
        parent.addView(makeCard(fw));
        return v;
    }
    public CardView makeCard(FriendlyWager fw){
        //makes a card
        CardView cv = new CardView(getContext());
        cv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        cv.setCardElevation(15);
        cv.setUseCompatPadding(true);
        //adds linear layout to the card
        LinearLayout li = new LinearLayout(getContext());
        li.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        li.setOrientation(LinearLayout.VERTICAL);

        cv.addView(li);

        //adds textviews to the linear layout
        TextView tv = new TextView(getContext());
        tv.setText(fw.getmName() + " - " + fw.getDate());
        li.addView(tv);

        tv = new TextView(getContext());
        tv.setText("$" + fw.getAmount());
        li.addView(tv);

        tv = new TextView(getContext());
        tv.setText("Wager with " + fw.getmParticipants().toString());
        li.addView(tv);

        tv = new TextView(getContext());
        tv.setText(fw.getTask());
        li.addView(tv);

        return cv;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
