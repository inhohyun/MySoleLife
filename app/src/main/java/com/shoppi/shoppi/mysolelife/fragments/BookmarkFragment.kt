package com.shoppi.shoppi.mysolelife.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.shoppi.shoppi.mysolelife.R
import com.shoppi.shoppi.mysolelife.databinding.FragmentBookmarkBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookmarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookmarkFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding : FragmentBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)
        binding.homeTap.setOnClickListener {
it.findNavController().navigate(R.id.action_bookmarkFragment_to_homeFragment)
        }
        binding.tipTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_tipFragment)

        }
        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_talkFragment)

        }
        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_storeFragment)

        }

        // Inflate the layout for this fragment
        return binding.root
    }

}