import com.max.BookingService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BookingServiceTests {

    /** Проверка работы Mockito */
    @Test
    public void simpleTest() {
        // Создаем мок
        List<String> mockedList = mock(List.class);

        // Используем мок
        mockedList.add("one");
        mockedList.clear();

        // Проверяем, что методы были вызваны
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void createBookTest() {
        BookingService mockBookingService = mock(BookingService.class);

        when(mockBookingService.createBook(anyString(), any(), any())).thenReturn(false);

        boolean result = mockBookingService.createBook(anyString(), any(), any());

        assertEquals(false, result);
    }

    @Test
    public void testBooking() {
        // Создаем мок объекты
        BookingService bookingService = mock(BookingService.class);
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);

        // Настраиваем поведение мок объектов
        when(bookingService.checkTimeInBD(from, to)).thenReturn(true);
        when(bookingService.createBook("user1", from, to)).thenReturn(true);

        // Вызываем метод, который хотим протестировать
        boolean result = bookingService.createBook("user1", from, to);

        // Проверяем результат
        assertTrue(result);
    }
}
