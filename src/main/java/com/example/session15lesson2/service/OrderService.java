package com.example.session15lesson2.service;

import com.example.session15lesson2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public String cancelOrder(Long orderId) {
        // Edge Case 1: ID âm
        if (orderId == null || orderId <= 0) {
            return "Lỗi: Mã đơn hàng không hợp lệ (phải là số dương).";
        }

        // Thực hiện cập nhật
        int updatedRows = orderRepository.cancelFraudulentOrder(orderId);

        if (updatedRows > 0) {
            return "Hủy đơn hàng " + orderId + " thành công.";
        } else {
            // Edge Case 2: Đã giao hàng hoặc ID không tồn tại
            // Lưu ý: Query ở Repo đã chặn status != 'DELIVERED'
            return "Lỗi: Không thể hủy đơn hàng. Lý do: Đơn hàng không tồn tại hoặc đã được giao thành công.";
        }
    }
}
