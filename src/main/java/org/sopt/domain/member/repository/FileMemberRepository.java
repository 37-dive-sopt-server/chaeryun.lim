package org.sopt.domain.member.repository;

import org.sopt.domain.member.entity.Gender;
import org.sopt.domain.member.entity.Member;
import org.sopt.global.exception.ErrorCode;
import org.sopt.global.exception.handler.MemberException;
import org.sopt.global.util.DateUtil;
import org.sopt.global.util.MemberIdGenerator;

import java.io.*;
import java.util.*;

public class FileMemberRepository implements MemberRepository, FileSavable{

    private static final String FILE_PATH = "src/main/resources/files/Member.txt";
    private final Map<Long, Member> store = new HashMap<>();

    public FileMemberRepository(){
        loadMemberDate();
    }

    // Member 파일 저장
    @Override
    public Member save(final Member member) {
        // 파일 저장
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(final Long id) {
        return store.containsKey(id) ? Optional.of(store.get(id)) : Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public void deleteById(final Long id) {
        if(!store.containsKey(id)){
            throw new MemberException(ErrorCode.NOT_FOUND_MEMBER);
        }
        store.remove(id);
    }

    @Override
    public Optional<Member> existMemberByEmail(final String email) {

        for (Member member : store.values()) {
            if (member.getEmail().equals(email)) {
                return Optional.of(member);
            }
        }

        return Optional.empty();
    }

    // 종료 전 파일 저장
    @Override
    public void saveFile(){
        try {
            File file = new File(FILE_PATH);

            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));    // 덮어쓰기 모드

            for (Member member : store.values()) {
                bw.write(String.valueOf(member.getId()));
                bw.write(", " + member.getName());
                bw.write(", " + member.getBirthDay().toString());
                bw.write(", " + member.getEmail());
                bw.write(", " + member.getGender().getDescription());
                bw.newLine();
            }

            bw.flush();
            bw.close();

        } catch (IOException e){
            throw new MemberException(ErrorCode.MEMBER_FILE_SAVE_ERROR);
        }
    }

    /**
     * 내부 로직
     */

    // 파일 불러오기
    private void loadMemberDate(){
        try {
            File file = new File(FILE_PATH);

            if (file.exists()){
                BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));

                String line = null;
                while ((line = br.readLine()) != null){
                    // split[]
                    // 0 -> id
                    // 1 -> name
                    // 2 -> birthDay
                    // 3 -> email
                    // 4 -> gender

                    String[] split = line.split(", ");

                    Member member = new Member.
                            Builder(Long.parseLong(split[0]), split[1])
                            .birthDay(DateUtil.string2Date(split[2]))
                            .email(split[3])
                            .gender(Gender.from(split[4]))
                            .build();

                    store.put(member.getId(), member);
                }

                br.close();
            }
        } catch (IOException e){
            throw new MemberException(ErrorCode.MEMBER_FILE_LOAD_ERROR);
        }

        // 가장 큰 Key 값 확인 후 ID 넣기
        store.keySet().stream().max(Long::compareTo).ifPresent(MemberIdGenerator::loadToId);
    }

}
