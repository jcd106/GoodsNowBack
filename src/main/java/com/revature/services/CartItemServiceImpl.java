package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CartItem;
import com.revature.repositories.CartItemRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemRepository cartItemRepo;
	
	@Override
	public CartItem addCartItem(CartItem newCartItem) {
		for (CartItem cartItem : findAllCartItems()) {
			if (cartItem.getCustomer().getCustomerId() == newCartItem.getCustomer().getCustomerId()
					&& cartItem.getItem().getItemId() == newCartItem.getItem().getItemId()) {
				int currQuant = cartItem.getQuantity();
				int newQuant = newCartItem.getQuantity();
				newCartItem.setQuantity(currQuant + newQuant);
			}
		}
		return cartItemRepo.save(newCartItem);
	}

	@Override
	public List<CartItem> findAllCartItems() {
		return cartItemRepo.findAll();
	}

	@Override
	public CartItem findCartItemByItemIdAndCustomerId(int itemId, int customerId) {
		return cartItemRepo.findCartItemByCartItemIdItemItemIdAndCartItemIdCustomerCustomerId(itemId, customerId);
	}

	@Override
	public List<CartItem> findCartItemsByCustomerId(int customerId) {
		return cartItemRepo.findCartItemsByCartItemIdCustomerCustomerId(customerId);
	}

	@Override
	public CartItem updateCartItemById(CartItem updatedCartItem) {
		return cartItemRepo.save(updatedCartItem);
	}

	@Override
	public void deleteCartItem(CartItem deleteCartItem) {
		cartItemRepo.delete(deleteCartItem);
	}

}
