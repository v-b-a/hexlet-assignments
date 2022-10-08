package exercise;

import lombok.*;

// BEGIN
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// END
class User {
    @NonNull
    int id;
    String firstName;
    String lastName;
    int age;
}
