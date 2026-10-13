package com.hritik.jpa.learnJpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// study indexing and partitioning

@Data // This makes this POJO Class. It adds @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder // REMEMBER this is used in audit logging
@Entity // JPA annotation to specify that this will be mapped to a table in our DB (Using hibernate obviously)
@Table(
        name = "product_table",
        uniqueConstraints = { // indexing is auto enabled on unique fields by default
                @UniqueConstraint(name = "title_price_unique", columnNames = {"title_x", "price"}) // combination of both should be unique
        },
        indexes = {
                @Index(name = "sku_index", columnList = "sku") // indexing on sku enabled means we commonly search on sku column
        }
)
public class ProductEntity {
    @Id // indexing is auto enabled on '@Id' fields by default
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String sku;

    @Column(name = "title_x")
    private String title;

    private BigDecimal price;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
